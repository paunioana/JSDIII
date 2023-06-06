export const ADD_TODOS = "ADD_TODOS";
export const SELECT_TODO = "SELECT_TODO";

export const addPosts = (todos) => {
    return {
        type: ADD_TODOS,
        payload: {
            todos: todos
        }
    };

};

export const selectToDo = (data) => {
  return {
      type: SELECT_TODO,
      payload: {
          data: data
      }

  };
};