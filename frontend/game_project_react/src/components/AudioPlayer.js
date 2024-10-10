import React, { useState } from "react";
import Howler from "react-howler";

const AudioPlayer = ({ showVolumeControl = false }) => {
  const [soundEnabled, setSoundEnabled] = useState(true);
  const [volume, setVolume] = useState(1);

  return (
    <div>
      <label>
        <input
          type="checkbox"
          checked={soundEnabled}
          onChange={() => setSoundEnabled((prev) => !prev)}
        />
        Sound
      </label>

      {soundEnabled && (
        <Howler
          src={`../resources/music/raining-village-video-game-theme-141777.mp3`}
          playing={true}
          loop={true}
          volume={volume}
        />
      )}

      {soundEnabled && showVolumeControl && (
        <div>
          <label>
            Volume:
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
      )}
    </div>
  );
};

export default AudioPlayer;
