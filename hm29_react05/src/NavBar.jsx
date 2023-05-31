import React from "react";
import {Link, Route, useParams} from "react-router-dom";
import SelectRepository from "./SelectRepository";


const NavBar = (props) => {
    const {repositoryId} = useParams();
    const linkStyle = {
        border: "1px solid #aaaaaa",
        padding: "4px",
        borderRadius: "4px",
        marginLeft: "4px",
        marginRight: "4px",
    };
    return (
        <div style={{padding: "8px"}}>
            <Link style={linkStyle} to="/home">
                Home
            </Link>
            <Link style={linkStyle} to="/repos">
                Repos
            </Link>
            <Link style={linkStyle} to="/repoInfo">
                Repo Info
            </Link>
            <Link style={linkStyle} to="/selectRepo">
                Select Repo
            </Link>
        </div>
    );
};

export default NavBar;