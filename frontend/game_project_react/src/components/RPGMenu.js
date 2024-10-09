import React, { useState } from 'react';
import Settings from './Settings.js';
import './RPGMenu.css';

const RPGMenu = () => {
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
      window.close();
    }
  };

  return (
    <div className="menu-container d-flex flex-column justify-content-center align-items-center">
      <h1 className="game-title">RPG Concept</h1>
      <div className="menu-buttons d-flex flex-column">
        <button className="btn btn-primary menu-btn">New Game</button>
        <button className="btn btn-secondary menu-btn">Continue</button>
        <button onClick={handleSettingsClick} className="btn btn-info menu-btn">Settings</button>
        <button onClick={handleExitClick} className="btn btn-danger menu-btn">Exit</button>
      </div>

      {showSettings && <Settings onClose={handleCloseSettings} />}
    </div>
  );
};

export default RPGMenu;
