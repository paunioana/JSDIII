import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";

const RepositoryDetails = (props) => {
    const { repositoryId } = useParams();
    const [repoURL, setRepoURL] = useState("");
    const [repoOwner, setRepoOwner] = useState("");
    const [repoName, setRepoName] = useState("");
    const [found, setFound] = useState(false);

    useEffect(() => {
        console.log(props.userName);
        fetch("https://api.github.com/users/"+ props.userName +"/repos")
            .then(response => response.json())
            .then((data) => {
                var numberID = Number(repositoryId);
                for(let i =0; i <data.length; i++) {
                    console.log(data[i].id);
                    console.log(data[i].id === numberID);
                    if(data[i].id === numberID) {
                        setRepoOwner(data[i].owner.login);
                        setRepoURL(data[i].html_url);
                        setRepoName(data[i].name);
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