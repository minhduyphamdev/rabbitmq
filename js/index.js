const formatUrl = (url, currentLang) => {
  const lastIndex = url.lastIndexOf(currentLang);
  let newUrl = url.substring(lastIndex);
  newUrl = newUrl.replace('.html','');
  newUrl = newUrl.split('/').join(':');
  return newUrl;
}

const buildSiteSection = (url) => {
  const siteSections = url.split(':');
  const arr = siteSections.map((ele,index) => {
    const key = 'level'+index;
    return {
        [key]: ele
    }
  })

  return arr;

}

// console.log(formatUrl('https://www.google.com/en/member/support','en'));
console.log(buildSiteSection('en:member:support'));