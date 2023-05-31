import "./Badge.css";
import React from "react";
class Badge extends React.Component {
    render() {
        const { name, repos, followers, following, avatarImage} = this.props;
        return (
            <div align="center">
            <div className="badge">
                <img
                    src={avatarImage}
                    height="64px"
                />
                <h3>{name}</h3>
                <h4>public repos: {repos}</h4>
                <p>followers: {followers}</p>
                <p>following: {following}</p>
            </div>
        </div>
        )

    }
};

export default Badge;