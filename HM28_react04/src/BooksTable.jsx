import {Modal, Box, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import {useEffect, useState} from "react";
import "./BooksTable.css";

const BooksTable = () => {
    const [books, setBooks] = useState([]);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [selectedImage, setSelectedImage] = useState("https://wallpapercave.com/wp/wp6127014.jpg");

    const modalStyle = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 400,
        boxShadow: 24
    };

    const modalImgStyle = {
        maxWidth: '100%',
        maxHeight: '100%',
    };

    useEffect(() => {
        fetch('https://fakerapi.it/api/v1/books?_quantity=15')
            .then(response => response.json())
            .then((data) => {
                setBooks(data.data);
            }).catch((err) => {
            console.log(err.message);
        });

    }, []);

    const evenStyle = {
        background: "#f5ea98",

    };

    const unevenStyle = {
        background: "#edaa7e"
    };

    const handleRowClick = (image) => {
        setSelectedImage(image);
        setModalIsOpen(true);
    };
    const deleteRow = (book) => {
        setBooks(books.filter(item => item.id !== book.id));

    };

    return (
        <>
            <TableContainer component={Paper}>
                <Table sx={{minWidth: 700}} aria-label="customized table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="left">ID</TableCell>
                            <TableCell align="left">TITLE</TableCell>
                            <TableCell align="left">AUTHOR</TableCell>
                            <TableCell align="left">GENRE</TableCell>
                            <TableCell align="left">DESCRIPTION</TableCell>
                            <TableCell align="left">ACTION</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {books.map(e => (
                            <TableRow className="bookRecord" key={e.id} style={e.id % 2 == 0 ? evenStyle : unevenStyle} onClick={() => handleRowClick(e.image)}>
                                <TableCell align="left">{e.id}</TableCell>
                                <TableCell align="left">{e.title}</TableCell>
                                <TableCell align="left">{e.author}</TableCell>
                                <TableCell align="left">{e.genre}</TableCell>
                                <TableCell align="left">{e.description}</TableCell>
                                <TableCell align="left">
                                    <button onClick={(event) => {
                                        deleteRow(e);
                                        event.stopPropagation()
                                    }
                                    }>DELETE ROW</button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            <Modal
                open={modalIsOpen}
                onClose={() => setModalIsOpen(false)}
            >
                <Box sx={modalStyle}>
                    <img style={modalImgStyle} src={selectedImage}/>
                </Box>
            </Modal>

        </>


    );

};
export default BooksTable;