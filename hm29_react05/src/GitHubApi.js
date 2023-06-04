import axios from "axios";

const BASE_API = "https://api.github.com";

export const getUserDetails = (userName) =>
    axios.get(`${BASE_API}/users/${userName}`);

export const getReposDetails = (userName) =>
    axios.get(`${BASE_API}/users/${userName}/repos`);
