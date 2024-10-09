import React from 'react';
import './App.css';
import RPGMenu from './components/RPGMenu';
import AudioPlayer from './components/AudioPlayer'; // Import the AudioPlayer

function App() {
  return (
    <div className="App">
      <AudioPlayer /> 
      <RPGMenu />
    </div>
  );
}

export default App;
