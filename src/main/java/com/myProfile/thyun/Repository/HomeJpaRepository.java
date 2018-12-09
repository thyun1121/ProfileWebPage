  package com.myProfile.thyun.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.myProfile.thyun.model.BlogPost;

@EnableJpaRepositories("com.myProfile.thyun.Repository") 
//https://jdm.kr/blog/121  참고.
public interface HomeJpaRepository extends JpaRepository<BlogPost, String>{
	
	@Query("SELECT  A.postNo"
			+",A.postTitle"
			+",A.postSubtitle"
			+",TO_CHAR(A.postDate,  'Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS postDate \n"
			+",A.postUrl \n"
			+"FROM BlogPost A \n"
			+"ORDER BY A.postNo DESC")
	List<BlogPost> findPostListNoDesc();
	
//	@Query("SELECT  B.subjectImgUrl"
//			+",B.subjectName \n"
//			+",A.postConts \n"
//			+"FROM BlogPost A \n"
//			+"JOIN A.subject B \n"
//			+"WHERE A.postUrl=:postUrl \n"
//			)
	@Query(value="SELECT B.*\n" + 
			"    , A.*    \n" + 
			"FROM TB_POST A\n" + 
			"    ,(\n" + 
			"        SELECT C.SUBJECT_NAME\n" + 
			"                ,LISTAGG(B.HASHTAG_NAME || ',') WITHIN GROUP (ORDER BY B.HASHTAG_NAME) AS HASTAG_NAME\n" + 
			"                ,C.SUBJECT_IMG_URL\n" + 
			"                ,C.POST_NO\n" + 
			"        FROM    TB_POST_HASHTAG A\n" + 
			"                ,TB_HASHTAG B\n" + 
			"                ,(\n" + 
			"                    SELECT SB.SUBJECT_NAME\n" + 
			"                            ,SB.SUBJECT_IMG_URL\n" + 
			"                            ,SA.POST_NO\n" + 
			"                      FROM TB_POST SA\n" + 
			"                            ,TB_SUBJECT SB\n" + 
			"                    WHERE SA.SUBJECT_NO = SB.SUBJECT_NO\n" + 
			"                      AND SA.POST_URL = :postUrl\n" + 
			"                ) C\n" + 
			"        WHERE   A.HASHTAG_NO = B.HASHTAG_NO\n" + 
			"         AND    A.POST_NO = C.POST_NO\n" + 
			"         GROUP BY C.SUBJECT_NAME\n" + 
			"                , C.SUBJECT_IMG_URL\n" + 
			"                ,C.POST_NO\n" + 
			"\n" + 
			") B\n" + 
			"WHERE A.POST_NO = B.POST_NO"
			,nativeQuery =true
			)
	List<BlogPost> findByPostUrlWithSubject(@Param("postUrl")String postUrl);
	
	
	BlogPost findByPostUrl(String postUrl);
	
	
}
