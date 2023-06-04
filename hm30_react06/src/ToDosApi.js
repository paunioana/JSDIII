import axios from "axios";

const BASE_API = "https://jsonplaceholder.typicode.com/";

export const getAllTodos = () => axios.get(`${BASE_API}todos`);

export const getPosts = () => axios.get(`${BASE_API}posts`);

export const getComments = (postID) => axios.get(`${BASE_API}comments?postId=${postID}`);

/*
Variante similare:
export const getAllTodos = () => {
    return axios.get(`${BASE_API}todos`);
};

export function getAllTodos () {
    return axios.get(`${BASE_API}todos`);
};
 */

export const getUserDetails = (userId) =>
    axios.get(`${BASE_API}users/${userId}`);