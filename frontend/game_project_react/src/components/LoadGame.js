import React from "react";

const LoadGame = ({ onBack }) => {
  return (
    <div className="load-game">
      <h1 className="load-game-header">LOAD GAME</h1>
      <div className="save-slot">
        <h2>1. The Hill of Fate</h2>
        <p>Character: John</p>
        <p>Job: Merchant</p>
        <p>Difficulty: NORMAL</p>
        <p>Game Time: 01:18:22</p>
      </div>
      <div className="save-slot">
        <h2>2. Empty</h2>
      </div>
      <div className="save-slot">
        <h2>3. Empty</h2>
      </div>
      <div className="load-game-footer">
        <button className="action-button">Accept</button>
        <button className="action-button" onClick={onBack}>
          Back
        </button>
        {/* Back Button */}
      </div>
    </div>
  );
};

export default LoadGame;
