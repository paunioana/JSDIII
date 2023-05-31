import {useEffect, useState} from "react";
import {Link, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import {useParams} from "react-router-dom";
import "./ReposComponent.css";

const ReposComponent = (props) => {
    const userName = props.userName;
    const [repos, setRepos] = useState([]);
    useEffect(() => {
        fetch("https://api.github.com/users/"+ userName +"/repos")
            .then(response => response.json())
            .then((data) => {
                setRepos(data);
            }).catch((err) => {
            console.log(err.message);
        });

    }, []);

    const evenStyle = {
        background: "#f5ea98",
    };

    const unevenStyle = {
        background: "#edaa7e"
    };
    const tableHeaderStyle = {
        background: "#04AA6D",
    color: "white"
    }

    return (
            <TableContainer component={Paper}>
                <Table sx={{minWidth: 700}} aria-label="customized table">
                    <TableHead>
                        <TableRow className="header">
                            <TableCell align="left">ID</TableCell>
                            <TableCell align="left">NAME</TableCell>
                            <TableCell align="left">OWNER</TableCell>
                            <TableCell align="left">LINK</TableCell>
                            <TableCell align="left">DESCRIPTION</TableCell>
                            <TableCell align="left">DEFAULT BRANCH</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {repos.map((e, index) => (
                            <TableRow className="repoRecord" key={index} style={index % 2 == 0 ? evenStyle : unevenStyle}>
                                <TableCell align="left">{index+1}</TableCell>
                                <TableCell align="left">{e.name}</TableCell>
                                <TableCell align="left">{e.owner["login"]}</TableCell>
                                <TableCell align="left">
                                    {e.url}
                                </TableCell>
                                <TableCell align="left">{e.description}</TableCell>
                                <TableCell align="left">{e.default_branch}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
    );
};
export default ReposComponent;