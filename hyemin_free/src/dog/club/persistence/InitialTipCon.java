package dog.club.persistence;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dog.club.domain.TipContent;

@WebListener
public class InitialTipCon implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context = sce.getServletContext();
		ArrayList<TipContent> datas = new ArrayList<TipContent>();
		
		//이미지, url, content 순서로 데이터넣기
		TipContent tip = new TipContent("https://post-phinf.pstatic.net/MjAxNzA5MjdfMTE4/MDAxNTA2NTA0NDQzODQz.uOt16uE1NkDFGFJT_-Y7BDIktWRfVH-2mSug5Bq7GJsg.PO1nMDn-jHbxizMCKDmzOo0xoRVhFuTxh_AhDia20V0g.JPEG/e834b30c28f5073ecd0b4107e7494392e36ae3d019b7144191f4c37d_1280.jpg?type=w1200",
				"https://terms.naver.com/entry.nhn?docId=4294511&cid=42883&categoryId=59597",
				"강아지 종류");
		datas.add(tip);
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzEyMTRfNDMg/MDAxNTEzMjExODgwOTA1.TvPKD5M0Fmdj-8MZAKbENxywyrJ5G83UqfCJL-1Qd5sg.iWKOO3IaMhF54YomfS3EmTQ7LjSZXOVJ9FhQTSdC8xsg.JPEG/dl.maxpixel.freegreatpicture.com.jpeg?type=w1200",
				"https://terms.naver.com/entry.nhn?docId=4356323&cid=42883&categoryId=59597",
				"반려견이 먹으면 안 되는 음식들"));
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzEwMjNfMTkx/MDAxNTA4NzIzOTczMDQ4.1ycpMOAs71WZzFZzB2z1y42qPD8aLAjhseYRo6Q9THkg.vRx3gBT-yx2cmdNWo9KiJm1uc3xn81cdb7PnnAvLem8g.JPEG/e83cb00d20f3053ecd0b4107e7494392e36ae3d019b9164396f9c47c_1280.jpg?type=w1200",
				"https://terms.naver.com/entry.nhn?docId=4296244&cid=42883&categoryId=59597",
				"강아지 예방접종"));
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzEyMjhfOTEg/MDAxNTE0NDIzNjQ2NTMy.mHnzjmdR_fLQjEBC05aC1LSzSeHTQ1Ftr2Cn2Fpi0ocg.CpurqruIEcUI_s-Het2ScN9fb-uf7SNB0kiXEqWG6wQg.JPEG/image_9704264271514423630009.jpg?type=w1200",
				"https://terms.naver.com/entry.nhn?docId=4368973&cid=42883&categoryId=59597",
				"반려견의 수면"));
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzEwMTlfNDkg/MDAxNTA4Mzg5ODE4ODU0.C5CzZWvtxqJAFPZDl_ns_m9_KfI23dbuaxz6y5ryxPIg.jATGqPj4720STNEbeLzOABRvFnhlPkdC_5gAsiauS5Qg.JPEG/GettyImages-496318390.jpg?type=w1200",
				"https://terms.naver.com/entry.nhn?docId=4296237&cid=42883&categoryId=59597",
				"강아지 배변 훈련"));
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzExMzBfMTkw/MDAxNTEyMDA1MjYxMDI3.Q_0WY2w_W55GasT2gsO9plRTNMmrHOTSwwrFNOZIKBMg.-wdyClaJAfR66tjx5-erL0MxSE6a9xjUKLhjzvJgXkYg.JPEG/dog-1178365_1920.jpg?type=w1200",
				"https://terms.naver.com/entry.nhn?docId=4353664&cid=42883&categoryId=59597",
				"반려견 목욕 시키기"));
		
		// 준비중 데이터 추가
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzExMDFfMyAg/MDAxNTA5NTAxNjk3NjE5.8BP9qPNuJGale34bbsDmeCC33R1crFyje0Bo3s2iwwMg.CjrCBDtFXg194skW7ii_-z4oUp5KFUSai7_bpv-B0Fwg.JPEG/dog-1378087_1920_%ED%94%BD%EC%82%AC%EB%B2%A0%EC%9D%B4.jpg?type=w1200","#","준비중"));
		datas.add(new TipContent("https://post-phinf.pstatic.net/MjAxNzA5MjhfMjg2/MDAxNTA2NTU0NDEyNzc1.hlN9ZVxKQJFBB19EEAUpyKcq7Oxe6R9ZbgyJ8U0rOJIg.EGMQDXLTGYgvqGT1WEWYkpywrs6Am1ZSOaw66d2X8Hcg.JPEG/photo-1498511897286-4f0782ab697d.jpg?type=w1200","#","준비중"));

		// application scope 에 members 및 member 객체 저장
		context.setAttribute("tipContents", datas);
		context.setAttribute("tipContent",new TipContent());
		
	}

}
