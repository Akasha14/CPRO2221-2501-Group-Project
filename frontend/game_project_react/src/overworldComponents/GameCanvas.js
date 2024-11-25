import React, { useEffect, useRef } from "react";
import "./GameCanvas.css";
import { resources } from "./GameResources.js";
import { Sprite } from "./Sprite.js";
import { Vector2 } from "./Vector2.js";
import { GameLoop } from "./GameLoop.js";
import { Input } from "./Input.js";

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
  });

  const shadow = new Sprite({
    resource: resources.images.shadow,
    frameSize: new Vector2(32, 32),
  });

  const heroPos = new Vector2(16 * 6, 16 * 5);
  const input = new Input();

  const update = () => {
    console.log(input.direction);
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
    const heroPosX = heroPos.x + heroOffset.x;
    const heroPosY = heroPos.y + heroOffset.y;

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
