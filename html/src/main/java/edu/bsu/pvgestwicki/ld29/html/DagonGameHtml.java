package edu.bsu.pvgestwicki.ld29.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import edu.bsu.pvgestwicki.ld29.core.DagonGame;

public class DagonGameHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // use config to customize the HTML platform, if needed
    HtmlPlatform platform = HtmlPlatform.register(config);
    platform.assets().setPathPrefix("dagon/");
    PlayN.run(new DagonGame());
  }
}
