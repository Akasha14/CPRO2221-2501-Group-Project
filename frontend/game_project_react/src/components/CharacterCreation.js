import React, { useState } from "react";

const CharacterCreation = ({ onCreateCharacter }) => {
  const [name, setName] = useState("");
  const [characterJob, setCharacterJob] = useState("Merchant"); // Default job

  const handleSubmit = (e) => {
    e.preventDefault();
    onCreateCharacter({ name, job: characterJob });
  };

  return (
    <div className="character-creation">
      <h2>Create Your Character</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </label>
        <label>
          Job:
          <select
            value={characterJob}
            onChange={(e) => setCharacterJob(e.target.value)}
          >
            <option value="Merchant">Merchant</option>
            <option value="Bandit">Bandit</option>
            <option value="Werewolf">Werewolf</option>
          </select>
        </label>
        <button type="submit">Create Character</button>
      </form>
    </div>
  );
};

export default CharacterCreation;
