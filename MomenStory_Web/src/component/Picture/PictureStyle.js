import styled from 'styled-components';

import left from '../../assest/lf.png'
import right from '../../assest/ri.png'

export const PictureWrapper = styled.div`

@media (min-width: 320px) and (max-width: 480px) {
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;
  user-select: none;

  & img {
    max-width: 100vw;
    border-radius: 8px;
  }
}

@media (min-width: 1281px) {
  width: calc(100vw - 100px);
  display: flex;
  align-items: center;
  justify-content: center;
  user-select: none;

  & img {
    max-width: 1000px;
    max-height: 700px;
    width: auto;
    height: auto;
    border-radius: 8px;
  }
}
`