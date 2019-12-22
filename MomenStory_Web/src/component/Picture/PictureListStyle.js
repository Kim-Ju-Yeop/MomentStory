import styled from 'styled-components';
import left from '../../assest/lf.png'
import right from '../../assest/ri.png'

import o from '../../assest/o.png'
import ba from '../../assest/ba.png'
import a from '../../assest/a.png'

export const PictureListWrapper = styled.div`
@media (min-width: 320px) and (max-width: 480px) {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100vh;
  width: 100vw;
  box-sizing: border-box;
  overflow: hidden;

  & .left {
    width: 636px;
    height: 749px;
    background-image: url(${left});
    background-size: cover;
  }

  & .right {
    width: 636px;
    height: 749px;
    background-image: url(${right});
    background-size: cover;
  }

  & .btn {
    position: absolute;
    background: none;
    border: none;
    background-size: cover;
    z-index: 1000;

    &:focus {
      outline: none;
    }

  }
  
}

@media (min-width: 1281px) {

  .pic {
    max-width: 453px;
    max-height: 274px;
    width: auto;
    height: auto;
  }

  .qqqqqqqqqqqq {
    width: 451px;
    margin-top: 10px;
    line-height: 40px;
    word-wrap: break-word;
    position: absolute;
    bottom: 215.5px;
  }

  .asasas {
    font-size: 16px;
  }

  .tttttt {
    font-size: 24px;
    margin-top: 12px;
    margin-bottom: 31px;
  }

  .img_wrapper {
    display: flex;
    justify-content: center;
    width: 453px;
  }

  display: flex;
  align-items: center;
  height: 100vh;
  width: 100vw;
  box-sizing: border-box;
  justify-content: center;
  overflow: hidden;
  padding-left: 100px;
  padding-right: 100px;
  z-index: ${props => props.intro ? -999 : 100};
  opacity: ${props => props.intro ? 0 : 1};
  transition: opacity 1s;

  & .sizing {
    transform: translateX(-60px);
  }

  & .left {
    width: 636px;
    height: 749px;
    background-image: url(${left});
    background-size: cover;
    padding-left: 101px;
    padding-top: 77px;
    box-sizing: border-box;
    position: relative;
    display: flex;
    flex-direction: column;
  }

  & .right {
    display: flex;
    align-items: flex-end;
    flex-direction: column;
    width: 636px;
    height: 749px;
    padding-top: 77px;
    padding-right: 101px;
    background-image: url(${right});
    background-size: cover;
    box-sizing: border-box;
    position: relative;
  }
  & .wrapper {
    display: flex;
    width: 1000vw;
    transform: translateX(${props => props.page && `calc(-${props.page * 100}vw + ${props.page * 100}px)`});
    transition: all .5s ease-out;
  }

  & .ppppppppppppppp {
    bottom: 117px;
    position: absolute;
    & p {
      width: 451px;
      border-bottom: 1.5px solid #d26969;
      margin-top: 40px;
    }
  }

  & .btn {
    display: flex;
    align-items: center;
    justify-content: center;
    background-size: cover;
    border: none;
    background-size: cover;
    cursor: pointer;
    width: 105px;
    height: 105px;
    transition: all .5s;
    display: ${props=>props.intro ? 'none':'flex'};
          background-image: url(${o});

    &:hover {
      transform: scale(1.2);
    }

    &:focus {
      outline: none;
    }

    &._left {
      & div{
      background-size: cover;
      width: 21px;
      height: 28px;
      background-image: url(${a});
      }
    }

    &._right {
      margin-left: -35px;
      & div {
      background-size: cover;
      width: 21px;
      height: 28px;
      background-image: url(${ba});
      }
    }
  }
}
`