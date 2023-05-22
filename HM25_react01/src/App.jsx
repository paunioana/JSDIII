import { useState } from 'react'
import viteLogo from '/vite.svg'
import hotpotLogo from './assets/Hotpot.png'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <a href="https://hotpot.ai/art-generator" target="_blank">
          <img src={hotpotLogo} className="hotpot" alt="hotpot logo" />
        </a>
      </div>
      <h1>AI Art Generator</h1>
        <p className="message-welcome">Welcome! This is my first React app!</p>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the image to learn more
      </p>
    </>
  )
}

export default App
