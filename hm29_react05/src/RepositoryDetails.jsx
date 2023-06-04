import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {getReposDetails} from "./GitHubApi";

const RepositoryDetails = (props) => {
    const { repositoryId } = useParams();
    const [repoURL, setRepoURL] = useState("");
    const [repoOwner, setRepoOwner] = useState("");
    const [repoName, setRepoName] = useState("");
    const [found, setFound] = useState(false);

    useEffect(() => {
        getReposDetails(props.userName)
            .then((response) => {
                var numberID = Number(repositoryId);
                for(let i =0; i <response.data.length; i++) {
                    console.log(response.data[i].id);
                    console.log(response.data[i].id === numberID);
                    if(response.data[i].id === numberID) {
                        setRepoOwner(response.data[i].owner.login);
                        setRepoURL(response.data[i].html_url);
                        setRepoName(response.data[i].name);
                        setFound(true);
                        break;
                    }
                }
            }).catch((err) => {
            console.log(err.message);
        });

    }, []);


    const check = () => {


        if(found) {
            return (<div>
                <div>selected repo with id: {repositoryId} and name: {repoName}</div>
                <div>owner: {repoOwner}</div>
                <a href={repoURL} target="_blank" rel="noopener noreferrer"> repo URL </a>
            </div>);
        } else {

            return (<div>Repo with the id: {repositoryId} does not exist, please select one from the dropdown</div>);
        }
    };


    return (<div>
            {check()}
        </div>


    );
};
export default RepositoryDetails;