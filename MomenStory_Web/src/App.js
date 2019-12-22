import React, { useState, useEffect } from 'react';
import { createGlobalStyle } from 'styled-components';
import { Route } from 'react-router-dom'
import { PictureListContainer } from './container'

import top from './assest/top.png'
import bottom from './assest/bottom.png'
import starting from './assest/starting_book.png'

const GlobalStyle = createGlobalStyle`

@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);

  body {
    width: 100vw;
    height: 100vh;
    overflow: hidden;
    font-family: 'Noto Sans KR';
  }

  .App {
    height: 100vh;
    width: 100vw;
    display: flex;
    align-items: center;
    justify-content: center;

    & .top {
      position: absolute;
      top: 0;
      right: 0;
    }

    & .bottom {
      position: absolute;
      bottom: 0;
      left: 0;
    }

    & .start {
      opacity:${props => props.intro ? 1: 0}
      display: flex;
      position: absolute;
      z-index: ${props => props.intro ? 100: -999};
      background-image: url(${starting});
      width: 1264.28px;
      height: 679px;
      align-items: center;
      justify-content: space-between;
      transition: all 1s;
      
      & .inside {
        margin-bottom: 50px;
       &.left {
         margin-left: 167px;
          line-height: 87px;
          font-size: 60px;

         & p {
           margin: 0;
         }
       }

       &.right {
        margin-right: 248.13px;
        width: 241.15px;
        height: 80px;
        background-color: #592e8d;
        border-radius: 40px;
        display: flex;
        align-items: center;
        justify-content: center;
        color: #ffffff;
        font-size: 24px;
      }
      }
    }
  }
`

function App() {
  const [intro, setIntro] = useState(true);

  return (
    <div className="App">
      <GlobalStyle intro = {intro}/>
      <img src = {top} className = "top" alt = "top"/>
      <img src = {bottom} className = "bottom" alt = "bottom"/>
      <div className = "start">
        <div className = "inside left" style = {{fontWeight:'bold'}}>
          <p>이영은님과</p>
          <p>부모님의 추억을</p>
          <p>선물해 드립니다</p>
        </div>
        <div style = {{cursor:'pointer'}} onClick = {() => {setIntro(false)}} className = "inside right" style = {{fontWeight:'bold'}}>
          읽어보기
        </div>
      </div>
      <Route path = "/:id" render = {() => <PictureListContainer intro = {intro}/>}/>
    </div>
  );
}

export default App;
