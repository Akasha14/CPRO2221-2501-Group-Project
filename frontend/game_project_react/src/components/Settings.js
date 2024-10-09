import React, { useState } from 'react';
import Howler from 'react-howler';
import './Settings.css';
import song from '../resources/music/raining-village-video-game-theme-141777.mp3';

const Settings = ({ onClose }) => {
  const [soundEnabled, setSoundEnabled] = useState(true);
  const [difficulty, setDifficulty] = useState('normal');
  const [volume, setVolume] = useState(1); 

  const toggleSound = () => {
    setSoundEnabled(prev => !prev);
  };

  return (
    <div className="settings-popup">
      <h2>Settings</h2>

      <div>
        <label>
          <input 
            type="checkbox" 
            checked={soundEnabled} 
            onChange={toggleSound} 
          />
          Sound
        </label>
      </div>

      <div>
        <label>
          Difficulty:
          <select value={difficulty} onChange={(e) => setDifficulty(e.target.value)}>
            <option value="easy">Easy</option>
            <option value="normal">Normal</option>
            <option value="hard">Hard</option>
          </select>
        </label>
      </div>

      {soundEnabled && (
        <div>
          <Howler
            src={song} 
            playing={true}
            loop={true} 
            volume={volume} 
            onPlay={() => console.log("Playing")} 
            onPause={() => console.log("Paused")} 
            onEnd={() => console.log("Ended")} 
          />
          <div>
            <label>
              Volume Test: 
              <input 
                type="range" 
                min="0" 
                max="1" 
                step="0.1" 
                value={volume} 
                onChange={(e) => setVolume(parseFloat(e.target.value))} 
              />
            </label>
          </div>
        </div>
      )}

      <button onClick={onClose} className="close-button">Close</button>
    </div>
  );
};

export default Settings;
