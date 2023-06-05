export const ADD_NOTE = "ADD_NOTE";
export const DELETE_NOTE = "DELETE_NOTE";

export const EDIT_NOTE = "EDIT_NOTE";

export const addNote = (title, description) => {
    return {
        type: ADD_NOTE,
        payload: {
            title: title, description: description
        }
    };
};

export const deleteNote = (title, description) => {
    return {
        type: DELETE_NOTE,
        payload: {
            title: title, description: description
        }
    };
};

export const editNote = (title, prevDescription, description) => {
    return {
        type: EDIT_NOTE,
        payload: {
            title: title, prevDescription: prevDescription, description: description
        }
    };

};