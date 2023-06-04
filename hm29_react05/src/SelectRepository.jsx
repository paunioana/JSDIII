import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import {getReposDetails} from "./GitHubApi";
const SelectRepository = (props) => {
    let [repoIndex, setRepoIndex] = useState(0);
    let [repos, setRepos] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getReposDetails(props.userName)
            .then((response) => {
                setRepos(response.data);
            }).catch((err) => {
            console.log(err.message);
        });

    }, []);
    const handleChange = (event) => {
        let path = '/repoInfo/' + repos[event.target.value].id;

        navigate(path, {userName: "paunioana"});

    };




    return (
        <div>
            <p></p>
            <FormControl width="100px">
                <InputLabel id="demo-simple-select-label">Repo</InputLabel>
                <Select
                    labelId="demo-simple-select-label"
                    value={-1}
                    label="Repo"
                    onChange={handleChange}
                >
                    <MenuItem value={-1}>Select an ID</MenuItem>
                    {repos.map((e, index) => (
                        <MenuItem value={index}>{e.name}</MenuItem>
                    ))}
                </Select>
            </FormControl>

        </div>
    );
};
export default SelectRepository;