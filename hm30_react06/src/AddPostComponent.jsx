import {Box, Button, IconButton, Snackbar, Stack, TextField} from "@mui/material";
import {useState} from "react";
import axios from "axios";
import MuiAlert from '@mui/material/Alert';
import React from "react";
import CloseIcon from "@mui/icons-material/Close";
import {addPost} from "./ToDosApi";

const Alert = React.forwardRef(function Alert(props, ref) {
    return <MuiAlert elevation={6} ref={ref} variant="filled" {...props} />;
});


const AddPostComponent = () => {
    const [userId, setUserId] = useState(0);
    const [title, setTitle] = useState("");
    const [body, setBody] = useState("");
    const [open, setOpen] = useState(false);
    const [response, setResponse] = useState("");
    const [severity, setSeverity] = useState("error");

    const addPostComp = (e) => {
        axios({
            method: 'post',
            url: "https://jsonplaceholder.typicode.com/posts",
            body: {
                "title": title,
                "body": body,
                "userId": userId
            },
            headers: {
                'Content-type': 'application/json',
            },
        }).then( (response) => {
            console.log(response.data);
            setOpen(true);
            setResponse("Post with id: " + response.data.id + " was successfully added!");
            setSeverity("success");
        })
            .catch( (error) => {
                console.log(error);
                setResponse("Failed to add post! Please try again...");
                setSeverity("error");
            });
    };
    const handleClose = () => {
        setOpen(false);
    };

    return(
        <div>
            <Box
                component="form"
                sx={{
                    '& .MuiTextField-root': { m: 1, width: '400px' },
                }}
                noValidate
                autoComplete="off"
            >
                <div>
                    <TextField required
                               id="userID"
                               onChange={(userID) => setUserId(Number(userID.target.value)) }
                               label="UserID"
                               defaultValue="your user ID"/>
                </div>
                <div>
                    <TextField
                        id="title"
                        label="Title"
                        onChange={(title) => setTitle(title.target.value) }
                        multiline
                        rows={2}
                        defaultValue="add title..."
                    />
                </div>
                <div>
                    <TextField
                        id="body"
                        onChange={(body) => setBody(body.target.value) }
                        label="Body"
                        multiline
                        rows={6}
                        defaultValue="add body..."
                    />
                </div>
                <div>
                    <button name="data" type="button" onClick={e => addPostComp(e)}>add post</button>
                </div>
            </Box>
            <Stack sx={{ width: '100%' }}>
                <Snackbar open={open}
                          autoHideDuration={6000}
                          onClose={handleClose}>
                    <Alert severity={severity} sx={{ width: '100%' }} onClose={handleClose} >
                        {response}
                    </Alert>

                </Snackbar>
            </Stack>
        </div>
    );

};
export default AddPostComponent;