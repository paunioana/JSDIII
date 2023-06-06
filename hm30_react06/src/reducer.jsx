import {ADD_TODOS, SELECT_TODO} from "./action";

const initialState = {
    todos:[],
    modalData: undefined
};

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_TODOS:
            return {
                todos:  action.payload.todos,
                modalData: undefined
            };
        case SELECT_TODO:
            return {
                todos: state.todos,
                modalData: action.payload.data
            };


        default:
            return state;
    }
};

export default rootReducer;