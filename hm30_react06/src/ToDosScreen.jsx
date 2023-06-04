import React from "react";
import {useState} from "react";
import {Box} from "@mui/material";
import {DataGrid} from '@mui/x-data-grid';
import {useEffect} from "react";
import {getAllTodos, getUserDetails} from "./ToDosApi.js";
import UserModal from "./UserModal.jsx";

const ToDosScreen = (props) => {
    const [todos, setTodos] = useState(undefined);
    const [modalData, setModalData] = useState(undefined);

    const columns = [
        {field: "id", headerName: "ID"},
        {field: "userId", headerName: "userId"},
        {field: "title", headerName: "Title", width: 400},
        {field: "completed", headerName: "Completed"},
    ];

    useEffect(() => {
        getAllTodos().then((response) => {
            setTodos(response.data);
        });
    }, []);

    const onCellClick = (cellInfo) => {
        const userId = cellInfo.row.userId;
        getUserDetails(userId)
            .then((userData) => {
                setModalData({
                    user: userData.data,
                    todo: cellInfo.row,
                });
            })
            .catch(() => {
                console.error("Something went wrong");
            });
    };

    return (
        <Box width="100%" height="100%" display="flex" justifyContent="center">
            {todos === undefined && <div>There is no todo yet</div>}
            {todos && (
                <Box width="80%">
                    <DataGrid onCellClick={onCellClick} rows={todos} columns={columns}/>
                </Box>
            )}
            {modalData && <UserModal modalData={modalData} onClose={() => setModalData(undefined)}/>}
        </Box>
    );
};

export default ToDosScreen;