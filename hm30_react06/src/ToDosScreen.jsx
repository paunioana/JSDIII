import React from "react";
// import {useState} from "react";
import {Box} from "@mui/material";
import {DataGrid} from '@mui/x-data-grid';
import {useEffect} from "react";
import {getAllTodos, getUserDetails} from "./ToDosApi.js";
import UserModal from "./UserModal.jsx";
import {useDispatch, useSelector} from "react-redux";
import {addPosts, selectToDo} from "./action";

const ToDosScreen = (props) => {
    //const [todos, setTodos] = useState(undefined);
    const todos = useSelector(store => store.todos);
    //const [modalData, setModalData] = useState(undefined);
    const modalData = useSelector(store => store.modalData);

    const columns = [
        {field: "id", headerName: "ID"},
        {field: "userId", headerName: "userId"},
        {field: "title", headerName: "Title", width: 400},
        {field: "completed", headerName: "Completed"},
    ];
    const dispatch = useDispatch();

    useEffect(() => {
        getAllTodos().then((response) => {
            dispatch(addPosts(response.data));
            //setTodos(response.data);
        });
    }, [dispatch]);

    const onCellClick = (cellInfo) => {
        const userId = cellInfo.row.userId;
        getUserDetails(userId)
            .then((userData) => {
                // setModalData({
                //     user: userData.data,
                //     todo: cellInfo.row,
                // });
                let dt = {
                    user: userData.data,
                    todo: cellInfo.row,
                };
                dispatch(selectToDo(dt));
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
            {modalData && <UserModal /*modalData={modalData}*/ onClose={() => dispatch(selectToDo(undefined))}/>}
        </Box>
    );
};

export default ToDosScreen;