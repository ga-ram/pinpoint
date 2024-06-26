import { colors } from '../constant';

export const getRandomColor = () => {
  const random = (Math.random() * 0xfffff * 1000000).toString(16);
  return `#${random.slice(0, 6)}`;
};

export const getLuminanceByBT709 = (hexColor: string) => {
  hexColor = hexColor.replace(/^#/, '');
  const r = parseInt(hexColor.substring(0, 2), 16);
  const g = parseInt(hexColor.substring(2, 4), 16);
  const b = parseInt(hexColor.substring(4, 6), 16);
  // 0 to 1 to indicate the degree of brightness.
  const luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;
  return luminance;
};

export const getContrastingTextColor = (hexBackgroundColor: string) => {
  const lumniance = getLuminanceByBT709(hexBackgroundColor);
  return lumniance > 128 ? colors.black : colors.white;
};

export const getDarkenHexColor = (hexColor: string, amount = 0.2) => {
  hexColor = hexColor.replace(/^#/, '');
  let r = parseInt(hexColor.substring(0, 2), 16);
  let g = parseInt(hexColor.substring(2, 4), 16);
  let b = parseInt(hexColor.substring(4, 6), 16);

  // 각 성분을 어둡게 함
  r = Math.max(0, Math.min(255, Math.floor(r * (1 - amount))));
  g = Math.max(0, Math.min(255, Math.floor(g * (1 - amount))));
  b = Math.max(0, Math.min(255, Math.floor(b * (1 - amount))));

  // 어두워진 RGB 값을 다시 hex로 변환
  const darkenedHex = `#${r.toString(16).padStart(2, '0')}${g.toString(16).padStart(2, '0')}${b.toString(16).padStart(2, '0')}`;

  return darkenedHex;
};
