import React, { useEffect } from 'react';

import * as S from './PictureListStyle.js';

import a from '../../assest/a.png'
import ba from '../../assest/ba.png'
import o from '../../assest/o.png'

const PictureList = ({intro, onHandleClick, page, leftData, rightData}) => {
  const leftGoal = parseInt(leftData.goal_time.substring(0, 2)) * 60 + parseInt(leftData.goal_time.substring(3,5));
  const rightGoal = parseInt(rightData.goal_time.substring(0, 2)) * 60 + parseInt(rightData.goal_time.substring(3,5));
  const leftImg = leftData.img.indexOf(',') === -1 ? leftData.img : leftData.img.substring(0, leftData.img.indexOf(','))
  const rightImg = rightData.img.indexOf(',') === -1 ? rightData.img : rightData.img.substring(0, rightData.img.indexOf(','))
  return (
    <S.PictureListWrapper page = {page} intro = {intro}>
      <div name = "left" className="btn _left" onClick = {onHandleClick}>
        <div/>
      </div>
      <div className ="left">
        <div className = "asasas">
          2019.12.22
        </div>
        <div className="tttttt">
        <span style = {{fontWeight:'bold'}}>{leftData.title}</span> {"- " + leftGoal +"분"}
        </div>
        <div className="img_wrapper">
        <img src = {"http://192.168.211.115:3000/" + leftImg} alt = "사진" className="pic"/>
        </div>    
        <div className = "ppppppppppppppp">
          <p></p>
          <p></p>
          <p></p>
        </div>
        <div className = "qqqqqqqqqqqq">
          {leftData.description}
        </div>
      </div>
      <div className ="right sizing">
        <div className = "asasas">
        2019.12.22
        </div>
        <div className="tttttt">
          <span style = {{fontWeight:'bold'}}>{rightData.title}</span>  {"- " + rightGoal +"분"}
        </div>
        <div className="img_wrapper">
        <img src = {"http://192.168.211.115:3000/" + rightImg} className="pic" alt = "사진"/>
        </div>
        <div className = "ppppppppppppppp">
          <p></p>
          <p></p>
          <p></p>
        </div>
        <div className = "qqqqqqqqqqqq">
          {rightData.description}
        </div>
      </div>
      <div  name = "right" className="btn _right" onClick = {onHandleClick}>
        <div />
      </div>
    </S.PictureListWrapper>
  );
};

export default PictureList;