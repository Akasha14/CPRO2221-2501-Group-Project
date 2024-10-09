import React, { useState, useEffect } from "react";
import { getJobs } from "../services/jobService";
import "./CharacterCreation.css"; // Ensure you import your CSS file

const CharacterCreation = ({ onCreateCharacter }) => {
  const [name, setName] = useState("");
  const [jobs, setJobs] = useState([]);
  const [characterJob, setCharacterJob] = useState(""); // Initially empty

  useEffect(() => {
    const fetchJobs = async () => {
      try {
        const data = await getJobs();
        setJobs(data);
        if (data.length > 0) {
          setCharacterJob(data[0].name); // Set default job to the first one
        }
      } catch (error) {
        console.error("Error fetching jobs:", error); // Log any errors
      }
    };

    fetchJobs();
  }, []);

  // Find the selected job based on the characterJob state
  const selectedJob = jobs.find((job) => job.name === characterJob);

  const handleSubmit = (e) => {
    e.preventDefault();

    const isConfirmed = window.confirm(
      "Are you sure you want to create this character?"
    );

    if (isConfirmed) {
      onCreateCharacter({ name, job: characterJob });
    } else {
      console.log("Character creation canceled.");
    }
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
            onChange={(e) => setCharacterJob(e.target.value)} // Update the characterJob on selection
          >
            {jobs.map((job) => (
              <option key={job.id} value={job.name}>
                {job.name}
              </option>
            ))}
          </select>
        </label>

        {selectedJob && (
          <div className="job-info">
            <h3>
              <u>Job Details</u>
            </h3>

            <div className="health-info">
              <img
                src="/sprites/heart.png" // Ensure the path is correct
                alt="Heart Icon"
                className="heart-icon"
              />
              <p>Health: {selectedJob.health}</p>
            </div>

            <div className="mana-info">
              <img
                src="/sprites/mana.png" // Ensure the path is correct
                alt="Mana Icon"
                className="mana-icon"
              />
              <p>Mana: {selectedJob.mana}</p>
            </div>

            <div className="defense-info">
              <img
                src="/sprites/shield.png" // Ensure the path is correct
                alt="Shield Icon"
                className="shield-icon"
              />
              <p>Defense: {selectedJob.defense}</p>
            </div>

            <div className="job-skills">
              <h4>Key Skills:</h4>
              <ul>
                {selectedJob.skills.map((skill, index) => (
                  <li key={index}>{skill}</li>
                ))}
              </ul>
            </div>
          </div>
        )}

        <button type="submit">Create Character</button>
      </form>
    </div>
  );
};

export default CharacterCreation;
