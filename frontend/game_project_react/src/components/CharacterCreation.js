import React, { useState } from "react";
import "./CharacterCreation.css";

// Dummy data for each job's stats and skills
const jobData = {
  Merchant: {
    health: 150,
    defense: 80,
    mana: 200,
    skills: ["Defensive Stance", "Coin Distraction", "Hire Mercenary"],
  },
  Bandit: {
    health: 120,
    defense: 50,
    mana: 175,
    skills: ["Smoke-Escape", "Backstab", "Dual-Wield"],
  },
  Werewolf: {
    health: 100,
    defense: 40,
    mana: 150,
    skills: ["Bite", "Claw Attack", "Howl"],
  },
};

const CharacterCreation = ({ onCreateCharacter }) => {
  const [name, setName] = useState("");
  const [characterJob, setCharacterJob] = useState("Merchant"); // Default job

  // Access stats and skills based on the selected job
  const selectedJobData = jobData[characterJob];

  const handleSubmit = (e) => {
    e.preventDefault();

    // Show confirmation pop-up on submission.
    const isConfirmed = window.confirm(
      "Are you sure you want to create this character?"
    );

    if (isConfirmed) {
      // If confirmed, create character.
      onCreateCharacter({ name, job: characterJob });
    } else {
      // If not confirmed, cancel.
      console.log("Character creation canceled.");
    }
  };
  return (
    <div className="character-creation">
      <h2>Create Your Character</h2>

      {/* Form creation. handleSubmit called on submit. */}
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          {/* Name input */}
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)} // Update name state on change.
            required
          />
        </label>
        <label>
          Job:
          {/* Job selection dropdown. */}
          <select
            value={characterJob}
            onChange={(e) => setCharacterJob(e.target.value)}
          >
            <option value="Merchant" className="merchant-option">
              Merchant
            </option>
            <option value="Bandit" className="bandit-option">
              Bandit
            </option>
            <option value="Werewolf" className="werewolf-option">
              Werewolf
            </option>
          </select>
        </label>

        {/* Display stats and skills for selected job. */}
        <div className="job-info">
          <h3>
            <u>Job Details</u>
          </h3>

          <div className="health-info">
            {/* Heart sprite. */}
            <img
              src="/sprites/heart.png"
              alt="Heart Icon"
              className="heart-icon"
            />
            <p>Health: {selectedJobData.health}</p>
          </div>

          <div className="mana-info">
            {/* Mana sprite. */}
            <img
              src="/sprites/mana.png"
              alt="Mana Icon"
              className="mana-icon"
            />
            <p>Mana: {selectedJobData.mana}</p>
          </div>

          <div className="defense-info">
            {/* Shield sprite. */}
            <img
              src="/sprites/shield.png"
              alt="Shield Icon"
              className="shield-icon"
            />
            <p>Defense: {selectedJobData.defense}</p>
          </div>

          <div className="job-skills">
            <h4>Key Skills:</h4>
            <ul>
              {/* Maps overs the list of skills in the selected job. */}
              {selectedJobData.skills.map((skill, index) => (
                <li key={index}>{skill}</li>
              ))}
            </ul>
          </div>
        </div>

        <button type="submit">Create Character</button>
      </form>
    </div>
  );
};

export default CharacterCreation;
