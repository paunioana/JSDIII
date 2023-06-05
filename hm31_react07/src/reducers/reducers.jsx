import {ADD_NOTE, DELETE_NOTE, EDIT_NOTE} from "../actionCreator/action";

const initialState = {
    notes: [],
};

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_NOTE:
            return {
                notes: [
                    ...state.notes,
                    {
                        title: action.payload.title,
                        description: action.payload.description,
                    },
                ],
            };

        case DELETE_NOTE:
            return {
                notes: state.notes.filter(e => (e.title !== action.payload.title && e.description !== action.payload.description))
            };
        case EDIT_NOTE:
            const index = this.state.findIndex(e => (e.title === action.payload.title && e.description === action.payload.prevDescription))
            return [
                ...state.notes.slice(0, index), // everything before current post
                {
                    title: action.payload.title,
                    description: action.payload.description
                },
                ...state.notes.slice(index + 1), // everything after current post
            ]


        default:
            return state;
    }
};

export default rootReducer;