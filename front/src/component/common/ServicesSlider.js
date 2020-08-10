import React from "react";
import { NavLink } from "react-router-dom";

const ServiceSlider = ({ slider }) => {
  const isActive = slider ? "serviceSlider active" : "serviceSlider";
  return (
    <div className={isActive}>
      <NavLink
        to="/cocktails/search"
        className="serviceSliderItem"
        activeClassName="navitem-active"
      >
        칵테일 찾기
      </NavLink>
      <div className="serviceSliderItem searchBar">바 찾기</div>
      <NavLink
        to="/recommend"
        className="serviceSliderItem"
        activeClassName="navitem-active"
      >
        칵테일 추천 받기
      </NavLink>
    </div>
  );
};

export default ServiceSlider;