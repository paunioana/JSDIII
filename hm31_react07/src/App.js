
import './App.css';
import NotesList from "./models/NotesList";
import AddNode from "./actions/AddNode";

function App() {
  return (
    <div>

      <NotesList></NotesList>
          <AddNode/>

    </div>
  );
}

export default App;
