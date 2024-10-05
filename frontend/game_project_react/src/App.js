import React, { useState } from "react";
import StartScreen from "./components/StartScreen";
import CharacterCreation from "./components/CharacterCreation";
import GameCanvas from "./components/GameCanvas";
import LoadGame from "./components/LoadGame";
import "./main.css";

const App = () => {
  // Boolean state to control the character creation screen
  const [isCharacterCreation, setIsCharacterCreation] = useState(false);
  
  // Object to hold character data after creation
  const [characterData, setCharacterData] = useState(null);
  
  // Boolean state to track if the game has started
  const [isGameStarted, setIsGameStarted] = useState(false);
  
  // New: Boolean state to track if the game is loading
  const [isLoadGame, setIsLoadGame] = useState(false);

  // Handle starting a new game by showing the character creation screen
  const handleStartNewGame = () => {
    setIsCharacterCreation(true);
  };

  // Handle loading a saved game
  const handleLoadGame = () => {
    setIsLoadGame(true); // Show LoadGame screen when button is clicked
  };

  // Go back to the start screen from LoadGame
  const handleBackToStart = () => {
    setIsLoadGame(false); // Hide LoadGame screen and go back to StartScreen
  };

  // Placeholder for the "continue game" functionality
  const handleContinueGame = () => {
    console.log("Continue game functionality to be implemented");
  };

  // Handle character creation, transition to the game canvas, and store character data
  const handleCreateCharacter = (character) => {
    setCharacterData(character); // Save the created character
    setIsCharacterCreation(false); // Exit character creation screen
    setIsGameStarted(true); // Start the game
    console.log("Character created:", character);
  };

  return (
    <div className="app">
      {isGameStarted ? ( 
        // If the game has started, display the game canvas
        <GameCanvas characterData={characterData} /> 
      ) : isCharacterCreation ? (
        // If character creation is in progress, display the character creation screen
        <CharacterCreation onCreateCharacter={handleCreateCharacter} />
      ) : isLoadGame ? (
        // Render load game screen
        <LoadGame onBack={handleBackToStart} />
      ) : (
        // Otherwise, show the start screen
        <StartScreen
          onStartNewGame={handleStartNewGame}
          onContinueGame={handleContinueGame}
          onLoadGame={handleLoadGame} // New prop to load the game
        />
      )}
      
      {/* Optionally display the created character info before the game starts */}
      {characterData && !isGameStarted && (
        <p>
          Character Created: {characterData.name}, Job: {characterData.job}
        </p>
      )}
    </div>
  );
};

export default App;
