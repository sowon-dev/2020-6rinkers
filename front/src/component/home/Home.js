import React from "react";
import TodayCocktail from "./TodayCocktail";
import "../../css/home/home.css";
import Recommendation from "./Recommendation";

const Home = () => {
  return (
    <div className="home">
      <TodayCocktail />
      <Recommendation />
    </div>
  );
};

export default Home;
