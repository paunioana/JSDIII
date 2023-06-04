import React from "react";
import {Link} from "react-router-dom";

const NavBar = (props) => {
    const linkStyle = {
        border: "1px solid #aaaaaa",
        padding: "4px",
        borderRadius: "4px",
        marginLeft: "4px",
        marginRight: "4px",
    };
    return (
        <div style={{padding: "8px"}}>
            <Link style={linkStyle} to="/todo">
                My To Do List
            </Link>
            <Link style={linkStyle} to="/posts">
                Posts
            </Link>
            <Link style={linkStyle} to="/addPost">
                Add Post
            </Link>
        </div>
    );
};

export default NavBar;