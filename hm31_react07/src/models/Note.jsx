import React, {useState} from "react";

import { useDispatch } from "react-redux";
import {deleteNote, editNote} from "../actionCreator/action";

const Note = (props) => {
    const dispatch = useDispatch();
    const [edit, setEdit] = useState(false);
    const [description, setDescription] = useState(props.description);
    const deleteObj = () => {
        dispatch(deleteNote(props.title, props.description));
    };

    const editObj = () => {
        setEdit(true);
    };

    const saveObj = () => {
        setEdit(false);
        editNote(props.title, props.description, description);
    }

    return (
        <div
            style={{
                width: "240px",
                height: "240px",
                background: "#f5b042",
                borderRadius: "10px",
                overflowY: "auto",
                margin: "4px",
                padding: "10px",
                display: "flex",
                flexDirection: "column"
            }}
        >
            <h3>{props.title}</h3>
            {edit===false && <span style={{ marginTop: "8px", flexGrow: 1 }} >{description}</span>}
            {edit && <textarea
                style={{
                    flex: 1,
                    width: "95%",
                    marginBottom: "4px",
                }}
                onChange={(event) => setDescription(event.target.value)}
                value={description}
            />}
            <div
                style={{
                    padding: "8px",
                    display: "flex",
                    justifyContent: "space-between",
                }}
            >
                {edit===false && <button onClick={editObj} name="edit" type="button">Edit</button>}
                {edit===true && <button onClick={saveObj} name="edit" type="button">Save</button>}
                <button onClick={deleteObj} name="remove"  type="button">Delete</button>

            </div>

        </div>
    );
};

export default Note;