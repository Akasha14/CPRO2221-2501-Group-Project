import React from "react";

const StartScreen = ({ onStartNewGame, onContinueGame }) => {
  return (
    <div className="start-screen">
      <h1>Welcome to the RPG Adventure!</h1>
      <button onClick={onStartNewGame}>New Game</button>
      <button onClick={onContinueGame}>Continue</button>
    </div>
  );
};

export default StartScreen;