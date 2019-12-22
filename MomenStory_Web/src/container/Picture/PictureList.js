import React, { useState, useEffect } from 'react';

import { withRouter } from 'react-router-dom';

import axios from 'axios';

import { PictureList } from '../../component'
import { PictureContainer } from '../'

import audio_file from '../../assest/book.wav'

const PictureListContainer = ({intro, match}) => {
  const [page, setPage] = useState(0);
  const [data, setData] = useState([{idx : null, user_email : null, title : null, description : null, goal_time : "????????", img : "????????"}, {idx : null, user_email : null, title : null, description : null, goal_time : "????????", img : "????????"}]);
  const id = match.params.id;
  const [leftData, setLeft] = useState({idx : null, user_email : null, title : null, description : null, goal_time : "????????", img : "????????"});
  const [rightData, setRight] = useState({idx : null, user_email : null, title : null, description : null, goal_time : "????????", img : "????????"});

  useEffect(() => {
    (async function() {
    const res = await axios.get(`http://192.168.211.115:3000/web/board`)
    if(res.data.message.length % 2 !== 0)
      setData([...res.data.message, {idx : null, user_email : null, title : null, description : null, goal_time : "????????", img : "????????"}])
    else
      setData([...res.data.message])
      setLeft(res.data.message[page * 2])
      setRight(res.data.message[page * 2 + 1])
    })()
  }, [])
  const audio = new Audio(audio_file);

  const onHandleClick = (e) => {
    audio.play()
    if(e.target.name === "left" && page > 0) {
      setPage(page - 1);
    }
    else if(e.target.name === "right" && page < Math.ceil(data.length / 2) - 1) {
      setPage(page + 1);
    }
    let dataa = data
    setLeft(dataa[page * 2])
    setRight(dataa[page * 2 + 1])
  }

  return (
    <PictureList leftData = {leftData} rightData = {rightData} intro = {intro} page = {page} onHandleClick = {onHandleClick} id = {id}/>
  );
};

export default withRouter(PictureListContainer);