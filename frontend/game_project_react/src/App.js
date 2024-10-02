import React, { useState } from "react";
import StartScreen from "./components/StartScreen";
import CharacterCreation from "./components/CharacterCreation";
import GameCanvas from "./components/GameCanvas";
import "./main.css";

const App = () => {
  // Boolean state to determine whether to display or not.
  const [isCharacterCreation, setIsCharacterCreation] = useState(false);
  // Object to hold characters data once submitted.
  const [characterData, setCharacterData] = useState(null);
  // Boolean state to determine whether the game has started
  const [isGameStarted, setIsGameStarted] = useState(false);

  // New game. Re-render with character creation screen.
  const handleStartNewGame = () => {
    setIsCharacterCreation(true);
  };

  // Continue game.(TO BE ADDED)
  const handleContinueGame = () => {
    console.log("Continue game functionality to be implemented");
  };

  // Update character data
  const handleCreateCharacter = (character) => {
    setCharacterData(character);
    setIsCharacterCreation(false); // Exit character creation
    setIsGameStarted(true); // Start the game
    console.log("Character created:", character);
    // Add further logic to start the game or load the game state
  };

  return (
    <div className="app">
      {isGameStarted ? ( // Check if the game has started
        <GameCanvas characterData={characterData} /> // Pass characterData if needed
      ) : isCharacterCreation ? (
        // True. Character creation screen.
        <CharacterCreation onCreateCharacter={handleCreateCharacter} />
      ) : (
        // False. Start screen.
        <StartScreen
          onStartNewGame={handleStartNewGame}
          onContinueGame={handleContinueGame}
        />
      )}
      {/* If character created, you can show additional information if needed */}
      {characterData && !isGameStarted && (
        <p>
          Character Created: {characterData.name}, Job: {characterData.job}
        </p>
      )}
    </div>
  );
};

export default App;
