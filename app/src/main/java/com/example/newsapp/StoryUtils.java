package com.example.newsapp;

import com.example.newsapp.data.Story;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StoryUtils {

    public static final String NEWS_BASE_URL = "http://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test";

    public static final String STORY_JSON = "{\n" +
            "  \"response\": {\n" +
            "    \"status\": \"ok\",\n" +
            "    \"userTier\": \"developer\",\n" +
            "    \"total\": 18025,\n" +
            "    \"startIndex\": 1,\n" +
            "    \"pageSize\": 10,\n" +
            "    \"currentPage\": 1,\n" +
            "    \"pages\": 1803,\n" +
            "    \"orderBy\": \"relevance\",\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"id\": \"politics/2021/mar/11/snp-focus-on-scottish-independence-is-wrong-debate-keir-starmer\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"politics\",\n" +
            "        \"sectionName\": \"Politics\",\n" +
            "        \"webPublicationDate\": \"2021-03-11T17:06:03Z\",\n" +
            "        \"webTitle\": \"SNP focus on Scottish independence is 'wrong debate', says Starmer \",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/politics/2021/mar/11/snp-focus-on-scottish-independence-is-wrong-debate-keir-starmer\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/politics/2021/mar/11/snp-focus-on-scottish-independence-is-wrong-debate-keir-starmer\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"music/2021/apr/10/music-streaming-debate-what-songwriter-artist-and-industry-insider-say-publication-parliamentary-report\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"music\",\n" +
            "        \"sectionName\": \"Music\",\n" +
            "        \"webPublicationDate\": \"2021-04-10T07:00:01Z\",\n" +
            "        \"webTitle\": \"The music streaming debate: what the artists, songwriters and industry insiders say\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/music/2021/apr/10/music-streaming-debate-what-songwriter-artist-and-industry-insider-say-publication-parliamentary-report\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/music/2021/apr/10/music-streaming-debate-what-songwriter-artist-and-industry-insider-say-publication-parliamentary-report\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/arts\",\n" +
            "        \"pillarName\": \"Arts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"world/2021/mar/10/mps-hit-back-after-india-summons-envoy-over-farmers-protest-debate\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"world\",\n" +
            "        \"sectionName\": \"World news\",\n" +
            "        \"webPublicationDate\": \"2021-03-10T16:29:33Z\",\n" +
            "        \"webTitle\": \"MPs hit back after India summons envoy over farmers' protest debate\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/world/2021/mar/10/mps-hit-back-after-india-summons-envoy-over-farmers-protest-debate\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/world/2021/mar/10/mps-hit-back-after-india-summons-envoy-over-farmers-protest-debate\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"uk-news/2021/feb/21/keep-out-of-bristols-slaver-street-names-debate-ministers-are-told\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"uk-news\",\n" +
            "        \"sectionName\": \"UK news\",\n" +
            "        \"webPublicationDate\": \"2021-02-21T08:15:55Z\",\n" +
            "        \"webTitle\": \"Keep out of Bristol’s slaver street names debate, ministers are told\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/uk-news/2021/feb/21/keep-out-of-bristols-slaver-street-names-debate-ministers-are-told\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/uk-news/2021/feb/21/keep-out-of-bristols-slaver-street-names-debate-ministers-are-told\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"society/2021/jan/18/tories-oppose-universal-credit-cut-keir-starmer-labour\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"society\",\n" +
            "        \"sectionName\": \"Society\",\n" +
            "        \"webPublicationDate\": \"2021-01-18T14:35:48Z\",\n" +
            "        \"webTitle\": \"Boris Johnson believes political debate should be 'kind and civil'\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/society/2021/jan/18/tories-oppose-universal-credit-cut-keir-starmer-labour\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/society/2021/jan/18/tories-oppose-universal-credit-cut-keir-starmer-labour\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"education/2020/dec/03/gavin-williamson-in-eton-mess-as-he-pitches-into-no-girls-policy\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"education\",\n" +
            "        \"sectionName\": \"Education\",\n" +
            "        \"webPublicationDate\": \"2020-12-03T20:01:32Z\",\n" +
            "        \"webTitle\": \"Eton College head denies stifling debate after teacher's dismissal\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/education/2020/dec/03/gavin-williamson-in-eton-mess-as-he-pitches-into-no-girls-policy\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/education/2020/dec/03/gavin-williamson-in-eton-mess-as-he-pitches-into-no-girls-policy\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"commentisfree/2020/dec/30/the-guardian-view-on-the-brexit-debate-no-scrutiny-no-choice\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"commentisfree\",\n" +
            "        \"sectionName\": \"Opinion\",\n" +
            "        \"webPublicationDate\": \"2020-12-30T18:56:29Z\",\n" +
            "        \"webTitle\": \"The Guardian view on the Brexit debate: no scrutiny, no choice | Editorial\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/commentisfree/2020/dec/30/the-guardian-view-on-the-brexit-debate-no-scrutiny-no-choice\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/commentisfree/2020/dec/30/the-guardian-view-on-the-brexit-debate-no-scrutiny-no-choice\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/opinion\",\n" +
            "        \"pillarName\": \"Opinion\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"commentisfree/2021/feb/12/elizabeth-britain-queen-consent-republicanism\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"commentisfree\",\n" +
            "        \"sectionName\": \"Opinion\",\n" +
            "        \"webPublicationDate\": \"2021-02-12T11:43:24Z\",\n" +
            "        \"webTitle\": \"Should Elizabeth II be Elizabeth the Last? At least allow Britain a debate | Polly Toynbee\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/commentisfree/2021/feb/12/elizabeth-britain-queen-consent-republicanism\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/commentisfree/2021/feb/12/elizabeth-britain-queen-consent-republicanism\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/opinion\",\n" +
            "        \"pillarName\": \"Opinion\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"environment/2020/aug/20/time-for-real-debate-on-river-regulation\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"environment\",\n" +
            "        \"sectionName\": \"Environment\",\n" +
            "        \"webPublicationDate\": \"2020-08-20T17:35:28Z\",\n" +
            "        \"webTitle\": \"Time for real debate on river regulation\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/environment/2020/aug/20/time-for-real-debate-on-river-regulation\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/environment/2020/aug/20/time-for-real-debate-on-river-regulation\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"politics/2021/apr/01/salmond-trying-to-trick-way-to-independence-says-sturgeon\",\n" +
            "        \"type\": \"article\",\n" +
            "        \"sectionId\": \"politics\",\n" +
            "        \"sectionName\": \"Politics\",\n" +
            "        \"webPublicationDate\": \"2021-04-01T16:18:13Z\",\n" +
            "        \"webTitle\": \"Alex Salmond to demand Alba party included in TV leadership debates\",\n" +
            "        \"webUrl\": \"https://www.theguardian.com/politics/2021/apr/01/salmond-trying-to-trick-way-to-independence-says-sturgeon\",\n" +
            "        \"apiUrl\": \"https://content.guardianapis.com/politics/2021/apr/01/salmond-trying-to-trick-way-to-independence-says-sturgeon\",\n" +
            "        \"isHosted\": false,\n" +
            "        \"pillarId\": \"pillar/news\",\n" +
            "        \"pillarName\": \"News\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    public static ArrayList<Story> fetchStories(String storiesJson){
        ArrayList<Story> stories = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(storiesJson);
            JSONObject response = jsonObject.getJSONObject("response");
            JSONArray results = response.getJSONArray("results");
            for (int i =0;i<results.length();i++){
                JSONObject result = results.getJSONObject(i);
                String type = result.getString("type");
                String sectionName = result.getString("sectionName");
                String title = result.getString("webTitle");

                Story story = new Story(sectionName,title,type);

                String publicationDate = result.getString("webPublicationDate");
                if (publicationDate!=null){
                    story.setPublishedDate(publicationDate);
                }

                String webUrl = result.getString("webUrl");
                story.setWebUrl(webUrl);

                stories.add(story);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stories;
    }
}
