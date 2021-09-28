/*
 * Copyright (c) 2021. DatameshGroup
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package au.com.dmg.fusion.request.displayrequest;

import com.squareup.moshi.Json;

public class DisplayOutput {
	@Json(name = "ResponseRequiredFlag")
	private final Boolean responseRequiredFlag;
	@Json(name = "Device")
	private final String device;
	@Json(name = "InfoQuality")
	private final String infoQuality;
	@Json(name = "OutputContent")
	private final OutputContent outputContent;

	public static class Builder {

		private Boolean responseRequiredFlag;
		private String device;
		private String infoQuality;
		private OutputContent outputContent;

		public Builder() {
		}

		Builder(Boolean responseRequiredFlag, String device, String infoQuality, OutputContent outputContent) {
			this.responseRequiredFlag = responseRequiredFlag;
			this.device = device;
			this.infoQuality = infoQuality;
			this.outputContent = outputContent;
		}

		public Builder responseRequiredFlag(Boolean responseRequiredFlag) {
			this.responseRequiredFlag = responseRequiredFlag;
			return Builder.this;
		}

		public Builder device(String device) {
			this.device = device;
			return Builder.this;
		}

		public Builder infoQuality(String infoQuality) {
			this.infoQuality = infoQuality;
			return Builder.this;
		}

		public Builder outputContent(OutputContent outputContent) {
			this.outputContent = outputContent;
			return Builder.this;
		}

		public DisplayOutput build() {
			if (this.responseRequiredFlag == null) {
				throw new NullPointerException("The property \"responseRequiredFlag\" is null. "
						+ "Please set the value by \"responseRequiredFlag()\". "
						+ "The properties \"responseRequiredFlag\", \"device\", \"infoQuality\" and \"outputContent\" are required.");
			}
			if (this.device == null) {
				throw new NullPointerException("The property \"device\" is null. "
						+ "Please set the value by \"device()\". "
						+ "The properties \"responseRequiredFlag\", \"device\", \"infoQuality\" and \"outputContent\" are required.");
			}
			if (this.infoQuality == null) {
				throw new NullPointerException("The property \"infoQuality\" is null. "
						+ "Please set the value by \"infoQuality()\". "
						+ "The properties \"responseRequiredFlag\", \"device\", \"infoQuality\" and \"outputContent\" are required.");
			}
			if (this.outputContent == null) {
				throw new NullPointerException("The property \"outputContent\" is null. "
						+ "Please set the value by \"outputContent()\". "
						+ "The properties \"responseRequiredFlag\", \"device\", \"infoQuality\" and \"outputContent\" are required.");
			}

			return new DisplayOutput(this);
		}
	}

	private DisplayOutput(Builder builder) {
		this.responseRequiredFlag = builder.responseRequiredFlag;
		this.device = builder.device;
		this.infoQuality = builder.infoQuality;
		this.outputContent = builder.outputContent;
	}
}

class OutputContent {

	@Json(name = "OutputFormat")
	private String outputFormat;
	@Json(name = "OutputText")
	private OutputText outputText;

	public OutputContent() {
	}

	public OutputContent(String outputFormat, OutputText outputText) {
		this.outputFormat = outputFormat;
		this.outputText = outputText;
	}

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public OutputText getOutputText() {
		return outputText;
	}

	public void setOutputText(OutputText outputText) {
		this.outputText = outputText;
	}

	@Override
	public String toString() {
		return "OutputContent [outputFormat=" + outputFormat + ", outputText=" + outputText + "]";
	}

}

class OutputText {

	@Json(name = "Text")
	private String text;

	public OutputText() {
	}

	public OutputText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "OutputText [text=" + text + "]";
	}

}

/*
package au.com.dmg.fusionsatellite.request.loginrequest
class DisplayOutput
@Required Boolean responseRequiredFlag
@Required String device
@Required String infoQuality
@Required String outputFormat
@Required String text
* */