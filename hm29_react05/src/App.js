import './App.css';
import {Route, Routes} from "react-router-dom";
import HomeComponent from "./HomeComponent";
import ReposComponent from "./ReposComponent";
import RepositoryDetails from "./RepositoryDetails";
import NavBar from "./NavBar";
import SelectRepository from "./SelectRepository";

function App() {

    return (
        <div className="App">
            <NavBar/>
            <Routes>
                <Route path="/home/:userName?" element={<HomeComponent />}/>
                <Route path="/:userName?"  element={<HomeComponent />}/>
                <Route path="/repos"  element={<ReposComponent userName={"paunioana"}/>}/>
                <Route path="/repoInfo/:repositoryId?" element={<RepositoryDetails userName={"paunioana"}/>}/>
                <Route path="/selectRepo" element={<SelectRepository userName={"paunioana"}/>}/>

            </Routes>
        </div>
    );
}

export default App;
