import {getPosts} from "./ToDosApi";
import React, {useEffect, useState} from "react";
import {Box} from "@mui/material";
import {DataGrid} from "@mui/x-data-grid";
import {getComments} from "./ToDosApi";
import CommentsModal from "./CommentsModal";
const PostsComponent = () => {
    const [posts, setPosts] = useState(undefined);
    const [modalData, setModalData] = useState(undefined);
    const columns = [
        {field: "userId", headerName: "userId"},
        {field: "id", headerName: "ID"},
        {field: "title", headerName: "Title", width: 400},
        {field: "body", headerName: "Body", width: 800}
    ];
    useEffect(() => {
        getPosts().then((response) => {
            setPosts(response.data);
        });
    }, []);

    const onCellClick = (cellInfo) => {
        const postId = cellInfo.row.id;
        getComments(postId)
            .then((postData) => {
                console.log(postData.data);
                setModalData({
                    comments: postData.data
                });
            })
            .catch(() => {
                console.error("Something went wrong");
            });
    };

    return (
        <Box width="100%" height="100%" display="flex" justifyContent="center">
            {posts === undefined && <div>There are no posts yet</div>}
            {posts && (
                <Box width="80%">
                    <DataGrid onCellClick={onCellClick} rows={posts} columns={columns}/>
                    {modalData && <CommentsModal modalData={modalData} onClose={() => setModalData(undefined)}/>}
                </Box>
            )}
        </Box>
    );

};
export default PostsComponent;