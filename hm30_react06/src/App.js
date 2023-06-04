import './App.css';
import ToDosScreen from "./ToDosScreen";
import {Route, Routes} from "react-router-dom";
import PostsComponent from "./PostsComponent";
import AddPostComponent from "./AddPostComponent";
import NavBar from "./NavBar";

function App() {
  return (
    <div className="App">
        <NavBar/>
        <p></p>
        <Routes>
            <Route path="/todo" element={<ToDosScreen/>}/>
            <Route path="/posts" element={<PostsComponent/>}/>
            <Route path="/addPost" element={<AddPostComponent/>}/>
        </Routes>

    </div>
  );
}

export default App;
