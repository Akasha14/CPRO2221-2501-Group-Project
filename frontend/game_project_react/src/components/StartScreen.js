import React, { useState } from "react";
import Settings from "./Settings.js"; // Assuming Settings component is already defined
import "./StartScreen.css"; // Assuming you have a CSS file for styling

const StartScreen = ({ onStartNewGame, onContinueGame, onLoadGame }) => {
  const [showSettings, setShowSettings] = useState(false);

  const handleSettingsClick = () => {
    setShowSettings(true);
  };

  const handleCloseSettings = () => {
    setShowSettings(false);
  };

  const handleExitClick = () => {
    const confirmExit = window.confirm("Are you sure you want to exit?");
    if (confirmExit) {
      window.close(); // This will attempt to close the window (may not work in some browsers)
    }
  };

  return (
    <div className="menu-container">
      <h1 className="game-title">Welcome to the RPG Adventure!</h1>
      <div className="menu-buttons">
        <button onClick={onStartNewGame} className="btn-primary menu-btn">
          New Game
        </button>
        <button onClick={onContinueGame} className="btn-secondary menu-btn">
          Continue
        </button>
        <button onClick={onLoadGame} className="btn-info menu-btn">
          Load Saved Games
        </button>
        <button onClick={handleSettingsClick} className="btn-info menu-btn">
          Settings
        </button>
        <button onClick={handleExitClick} className="btn-danger menu-btn">
          Exit
        </button>
      </div>

      {showSettings && <Settings onClose={handleCloseSettings} />}
    </div>
  );
};

export default StartScreen;
