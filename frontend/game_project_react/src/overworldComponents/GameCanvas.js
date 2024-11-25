import React, { useEffect, useRef } from "react";
import "./GameCanvas.css";
import { resources } from "./GameResources.js";
import { Sprite } from "./Sprite.js";
import { Vector2 } from "./Vector2.js";
import { GameLoop } from "./GameLoop.js";
import { Input, DOWN, UP, LEFT, RIGHT } from "./Input.js";
import { gridCells, isSpaceFree } from "./helpers/grid.js";
import { moveTowards } from "./helpers/moveTowards.js";
import { walls } from "./walls/overworld.js";

const GameCanvas = ({ characterData, onStartNewGame, onContinueGame }) => {
  // Create a ref for the canvas element
  const canvasRef = useRef(null);

  const skySprite = new Sprite({
    resource: resources.images.sky,
    frameSize: new Vector2(320, 180),
  });

  const groundSprite = new Sprite({
    resource: resources.images.ground,
    frameSize: new Vector2(320, 180),
  });

  const hero = new Sprite({
    resource: resources.images.hero,
    frameSize: new Vector2(32, 32),
    hFrames: 3,
    vFrames: 8,
    frame: 1,
    position: new Vector2(gridCells(6), gridCells(5)),
  });

  const heroDestinationPosition = hero.position.duplicate();

  const shadow = new Sprite({
    resource: resources.images.shadow,
    frameSize: new Vector2(32, 32),
  });

  const input = new Input();

  const update = () => {
    const distance = moveTowards(hero, heroDestinationPosition, 1);
    const hasArrived = distance <= 1; // Allows wiggle room so character will finish moving to grid spot.
    if (hasArrived) {
      tryMove();
    }
  };

  const tryMove = () => {
    if (!input.direction) {
      return;
    }

    let nextX = heroDestinationPosition.x;
    let nextY = heroDestinationPosition.y;
    const gridSize = 16;

    if (input.direction === DOWN) {
      nextY += gridSize;
      hero.frame = 0;
    }
    if (input.direction === UP) {
      nextY -= gridSize;
      hero.frame = 6;
    }
    if (input.direction === LEFT) {
      nextX -= gridSize;
      hero.frame = 9;
    }
    if (input.direction === RIGHT) {
      nextX += gridSize;
      hero.frame = 3;
    }

    // Check for walls.
    if (isSpaceFree(walls, nextX, nextY)) {
      heroDestinationPosition.x = nextX;
      heroDestinationPosition.y = nextY;
    }
  };

  // Draw function
  const draw = () => {
    if (!canvasRef.current) return;
    const ctx = canvasRef.current.getContext("2d");
    ctx.clearRect(0, 0, canvasRef.current.width, canvasRef.current.height);

    // Draw sprites
    skySprite.drawImage(ctx, 0, 0);
    groundSprite.drawImage(ctx, 0, 0);

    const heroOffset = new Vector2(-8, -21);
    const heroPosX = hero.position.x + heroOffset.x;
    const heroPosY = hero.position.y + heroOffset.y;

    shadow.drawImage(ctx, heroPosX, heroPosY);
    hero.drawImage(ctx, heroPosX, heroPosY);
  };

  useEffect(() => {
    const canvas = canvasRef.current;
    if (canvas) {
      const ctx = canvas.getContext("2d");

      ctx.imageSmoothingEnabled = false;

      // Set up the drawing interval
      const gameLoop = new GameLoop(update, draw);
      gameLoop.start();
    }
  }, []);

  return (
    <canvas id="gameCanvas" ref={canvasRef} width="320" height="180"></canvas>
  );
};

export default GameCanvas;
