package expencive.vk.com.comicsreader.Interface;

import java.util.List;

import expencive.vk.com.comicsreader.Model.Comic;

public interface IComicsLoadDone {

    void onComicLoadDoneListener(List<Comic> comicList);

}
