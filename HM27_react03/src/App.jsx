import './App.css'
import Counter from "./Counter.jsx";
import Stopwatch from "./Stopwatch.jsx";
import WelcomeMessage from "./WelcomeMessage.jsx";

function App() {

  return (

      <div>
          <WelcomeMessage></WelcomeMessage>
          <img className="logo" width="200px" src="https://www.devmind.ro/static/imgs/big-f65889fd23d95255a2cf6088b3f3eb53.png" />
     <Counter/>
          <Stopwatch/>
      </div>


  )
}

export default App
