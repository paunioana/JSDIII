import React, {useEffect, useState} from "react";
import {useParams, useNavigate} from "react-router-dom";
import Badge from "./Badge";
import {getUserDetails} from "./GitHubApi";

const HomeComponent = () => {
    const navigate = useNavigate();
    let { userName = "paunioana" } = useParams();

    const [followers, setFollowers] = useState();
    const [following, setFollowing] = useState();
    const [public_repos, setPublic_repos] = useState();
    const [avatar_url, setAvatar_url] = useState();

    useEffect(() => {
        getUserDetails(userName)
            .then((response) => {
                // console.log(response.data);
                setFollowers(response.data["followers"]);
                setFollowing(response.data["following"]);
                setPublic_repos(response.data["public_repos"]);
                setAvatar_url(response.data["avatar_url"]);
            }).catch((err) => {
            console.log(err.message);
        });

    }, []);

    return (
        <div>
            <Badge name={userName} followers={followers} following={following} repos={public_repos} avatarImage={avatar_url}/>
            <p></p>
            <button className="reposButton" onClick={() => navigate('/repos/', {userName : "paunioana"})}>Go to repos section</button>
        </div>
    )
};

export default HomeComponent;