export const MOBILE_WIDTH = 700;
export const isDesktop = () => window.innerWidth > MOBILE_WIDTH;

export const DOWN = 40;
export const UP = 38;
export const ENTER = 13;
export const ESC = 27;

export const USER_PROTOTYPE = {
  id: 0,
  name: "",
  email: "",
  imageUrl: "",
  provider: "",
  providerId: "",
  role: "",
  roleName: "",
  myFavorites: [],
};

export const TERMINOLOGY_ADMIN_PROTOTYPE = {
  id: 0,
  name: "",
  terminologyType: "",
  description: "",
  imageUrl: "",
};

export const INGREDIENT_ADMIN_PROTOTYPE = {
  id: 0,
  title: "",
  color: "",
  abv: "",
}

export const ACCESS_TOKEN = "accessToken";
export const API_BASE_URL = `//${process.env.REACT_APP_HOST}`;
export const OAUTH2_REDIRECT_URI = `${API_BASE_URL}/oauth2/redirect`;
export const GOOGLE_AUTH_URL = `${API_BASE_URL}/api/oauth2/authorize/google?redirect_uri=${OAUTH2_REDIRECT_URI}`;
